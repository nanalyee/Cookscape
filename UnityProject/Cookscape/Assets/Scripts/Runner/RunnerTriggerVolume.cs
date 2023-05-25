using UnityEngine;
using Photon.Pun;

namespace UnityProject.Cookscape
{
    public class RunnerTriggerVolume : MonoBehaviourPun
    {
        PhotonView m_PhotonView;
        Rigidbody m_Rigidbody;

        public bool CanSaveCatchee = true;
        public bool CanSpinValve = false;
        public bool NowRiding = false;

        public Collider nowTrigger;

        private void Start()
        {
            m_PhotonView = gameObject.GetComponent<PhotonView>();
            m_Rigidbody = gameObject.GetComponent<Rigidbody>();
        }

        private void OnTriggerEnter(Collider other)
        {
            CheckTrigger(other, true);
        }

        private void OnTriggerExit(Collider other)
        {
            CheckTrigger(other, false);
        }

        void CheckTrigger(Collider other, bool flag)
        {

            if (flag) nowTrigger = other;
            

            if (other.CompareTag("Jail"))
            {
                //CanSaveCatchee = flag;
            }
            else if (other.CompareTag("Valve"))
            {
                CanSpinValve = flag;
            }
            else if (other.CompareTag("Exit"))
            {
                if ( flag )
                    m_PhotonView.RPC(nameof(EscapeSuccess), RpcTarget.AllBuffered, m_PhotonView.ViewID);
            }
            else if (other.CompareTag("Ridable"))
            {
                NowRiding = flag;
                //RideRPC(m_PhotonView.ViewID, flag);
                // m_PhotonView.RPC(nameof(RideRPC), RpcTarget.AllBuffered, m_PhotonView.ViewID, flag);

                if (flag)
                {
                    m_Rigidbody.transform.SetParent(other.transform, true);
                }
                else
                {
                    m_Rigidbody.transform.SetParent(null, true);
                    Quaternion currentRotation = transform.rotation;
                    Quaternion newRotation = Quaternion.Euler(0, currentRotation.eulerAngles.y, 0);
                    transform.rotation = newRotation;
                }
            }
        }

        [PunRPC]
        public void EscapeSuccess(int ViewID)
        {
            if ( m_PhotonView.ViewID != ViewID)
            {
                return;
            }

            PlayInfo playInfo = GetComponent<PlayInfo>();
            playInfo.IsEscape = true;
            playInfo.IsWin = true;

            if ( m_PhotonView.IsMine)
                playInfo.SaveData();

            GetComponent<Runner>().m_IsDead = true;
            GetComponent<Rigidbody>().isKinematic = true;
            GetComponent<AudioSource>().enabled = false;

            // ĳ������ Mesh Renderer�� ��Ȱ��ȭ
            Renderer[] meshRenderers = GetComponentsInChildren<Renderer>();
            foreach (Renderer meshRenderer in meshRenderers)
            {
                meshRenderer.enabled = false;
            }

            // ĳ������ Collider�� ��Ȱ��ȭ
            Collider[] colliders = GetComponentsInChildren<Collider>();
            foreach (Collider collider in colliders)
            {
                collider.enabled = false;
            }

        }

        [PunRPC]
        void RideRPC(int ViewID, bool flag)
        {
            if ( m_PhotonView.ViewID != ViewID)
            {
                return;
            }

            if (flag)
            {

                transform.SetParent(nowTrigger.transform, true);
                VehicleController now = nowTrigger.GetComponent<VehicleController>();
                if (now)
                {
                    now.playerRigidbody.Add(m_Rigidbody);
                }
                else
                {
                    now = nowTrigger.GetComponentInParent<VehicleController>();

                    if ( now)
                    {
                        now.playerRigidbody.Add(m_Rigidbody);
                    }
                }
            }
            else
            {
                transform.SetParent(null, true);

                Quaternion currentRotation = transform.rotation;
                Quaternion newRotation = Quaternion.Euler(0, currentRotation.eulerAngles.y, 0);
                transform.rotation = newRotation;

                VehicleController now = nowTrigger.GetComponent<VehicleController>();
                if (now)
                {
                    now.playerRigidbody.Remove(m_Rigidbody);
                }
                else
                {
                    now = nowTrigger.GetComponentInParent<VehicleController>();

                    if (now)
                    {
                        now.playerRigidbody.Remove(m_Rigidbody);
                    }
                }
            }

            if (!flag) nowTrigger = null;
        }
    }
}
