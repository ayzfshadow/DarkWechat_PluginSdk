package ayzf.mcsq.dw.plugin;

import android.graphics.Bitmap;
import android.os.RemoteException;
import ayzf.mcsq.dw.msg.Messenger;

/**
 * @Author MCSQNXA
 * @CreateTime 2022-06-25 09:04:06
 * @Description 插件回调
 * @noinspection JavadocDeclaration
 */
public interface PluginBinderHandler
{
    void onLoad() throws RemoteException;

    void onUnLoad() throws RemoteException;

    void onMsgHandler(Messenger messenger) throws RemoteException;

    Bitmap icon() throws RemoteException;

    String name() throws RemoteException;

    String info() throws RemoteException;

    String author() throws RemoteException;

    String version() throws RemoteException;

    String activity() throws RemoteException;
}
