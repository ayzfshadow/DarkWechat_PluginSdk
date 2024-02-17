package ayzf.mcsq.dw.msg;

/**
 * @Author 暗影之风
 * @CreateTime 2024-02-17 19:09:09
 * @Description 消息类型
 * @noinspection JavadocDeclaration
 */
public class Msg
{
    public static final String MSGTYPE_TEXT = String.valueOf(1);
    public static final String MSGTYPE_IMAGE = String.valueOf(3);
    public static final String MSGTYPE_VOICE = String.valueOf(34);
    public static final String MSGTYPE_VIDEO = String.valueOf(43);
    public static final String MSGTYPE_MICROVIDEO = String.valueOf(62);
    public static final String MSGTYPE_EMOTICON = String.valueOf(47);
    public static final String MSGTYPE_APP = String.valueOf(49);
    public static final String MSGTYPE_VOIPMSG = String.valueOf(50);//voip msg
    public static final String MSGTYPE_VOIPNOTIFY = String.valueOf(52);//voip 结束消息
    public static final String MSGTYPE_VOIPINVITE = String.valueOf(53);//voip 邀请
    public static final String MSGTYPE_LOCATION = String.valueOf(48);
    public static final String MSGTYPE_STATUSNOTIFY = String.valueOf(51);
    public static final String MSGTYPE_SYSNOTICE = String.valueOf(9999);
    public static final String MSGTYPE_POSSIBLEFRIEND_MSG = String.valueOf(40);
    public static final String MSGTYPE_VERIFYMSG = String.valueOf(37);
    public static final String MSGTYPE_SHARECARD = String.valueOf(42);
    public static final String MSGTYPE_SYS = String.valueOf(10000);
    public static final String MSGTYPE_RECALLED = String.valueOf(10002);
}