using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using UnityProject.Cookscape;
using UnityProject.Cookscape.Api;

public class NicknameCardController : MonoBehaviour
{
    public TextMeshProUGUI nickname;
    public Toggle setNicknameToggle;

    public void CardAnimation()
    {
        if (this.gameObject.GetComponent<RectTransform>().anchoredPosition.y < -30 )
        {
            this.gameObject.GetComponent<RectTransform>().anchoredPosition = new Vector3(0, 0);
        }
        else
        {
            this.gameObject.GetComponent<RectTransform>().anchoredPosition = new Vector3(0, -42);
        }
    }

    public void NicknameChange()
    {
        string changeNickname = nickname.text;
        if (setNicknameToggle.isOn)
        {
            Debug.Log(changeNickname + "���� Īȣ�� �����մϴ�");
            UnityProject.Cookscape.User user = GameManager.instance.user;
            user.title = changeNickname;
            MetabusManager.instance.SetUserTitle();
            StartCoroutine(UnityProject.Cookscape.Api.User.instance.UpdateUser(new UserUpdateForm(user.avatarName, user.title, user.hat)));
        } 
        else
        {
            Debug.Log("�������� Īȣ " + changeNickname + "�� �����մϴ�");
        }
    }
}
