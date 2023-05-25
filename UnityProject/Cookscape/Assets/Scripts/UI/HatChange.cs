using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityProject.Cookscape;

public class HatChange : MonoBehaviour
{
    public void EquipedHat(bool flag)
    {
        User user = GameManager.instance.user;
        user.hat = RewardBookScript.instance.NowKeyValue;

        GameManager.instance.player.GetComponent<PlayerController>().SetHat();
        if (flag)
        {
            Debug.Log($"{user.hat} ¿Â¬¯");
            StartCoroutine(UnityProject.Cookscape.Api.User.instance.UpdateUser(new UserUpdateForm(user.avatarName, user.title, user.hat)));
        }
        else
        {
            Debug.Log($"{user.hat} ¿Â¬¯«ÿ¡¶");
            StartCoroutine(UnityProject.Cookscape.Api.User.instance.UpdateUser(new UserUpdateForm(user.avatarName, user.title, user.hat)));
        }
    }
}
