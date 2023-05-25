using System.Collections;
using System.Collections.Generic;
using Photon.Pun;
using UnityEngine;

public class VehicleAnimationController : MonoBehaviourPunCallbacks
{
    public Animator animator;
    public PhotonView photonView;
    private float syncInterval = 1f;
    private float timeSinceLastSync = 0f;

    private void Start()
    {
        // if (photonView == null) {
        //     photonView = GetComponentInParent<PhotonView>();
        // }
    }

    private void Update()
    {
        if (animator == null) return;

        if (photonView.IsMine)
        {
            timeSinceLastSync += Time.deltaTime;
            if (timeSinceLastSync >= syncInterval)
            {
                timeSinceLastSync = 0f;
                photonView.RPC("SyncAnimationTimeRPC", RpcTarget.Others, animator.GetCurrentAnimatorStateInfo(0).normalizedTime);
            }
        }
    }

    [PunRPC]
    private void SyncAnimationTimeRPC(float normalizedTime)
    {
        animator.Play("Idle", 0, normalizedTime);
    }
}
