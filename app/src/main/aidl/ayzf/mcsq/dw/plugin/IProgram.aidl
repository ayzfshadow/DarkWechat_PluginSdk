package ayzf.mcsq.dw.plugin;

import ayzf.mcsq.dw.msg.Messenger;

interface IProgram
{
    Messenger send(in String id,in String service,in Messenger msg);//发送消息

    void printI(in String id,in String service,in String info);//打印信息

    void printW(in String id,in String service,in String warn);//打印警告

    void printE(in String id,in String service,in String error);//打印错误
}
