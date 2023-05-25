using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TmpScreen : MonoBehaviour
{
    public void OnClick()
    {
        Screen.fullScreen = !Screen.fullScreen;
    }
}
