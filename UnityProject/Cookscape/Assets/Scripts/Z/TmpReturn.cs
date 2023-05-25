using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TmpReturn : MonoBehaviour
{
    public void OnClick()
    {
        GameManager.instance.TmpHideExitMenu();
    }

    public void ToggleScreen()
    {
        Screen.fullScreen = !Screen.fullScreen;
    }
}
