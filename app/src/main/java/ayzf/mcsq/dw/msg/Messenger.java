package ayzf.mcsq.dw.msg;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author MCSQNXA
 * @CreateTime 2022-02-19 11:28:38
 * @Description 消息
 * @noinspection JavadocDeclaration
 */
public class Messenger implements Parcelable
{
    /**
     * @CreateTime 2022-02-19 11:36:34
     * @Description 消息内容
     */
    private final ArrayList<HashMap<String, String>> list = new ArrayList<>();

    /**
     * @CreateTime 2022-06-09 18:44:18
     * @Description 编译器自动生成
     */
    public static final Parcelable.Creator<Messenger> CREATOR = new Parcelable.Creator<Messenger>() {
        @Override
        public Messenger createFromParcel(Parcel in)
        {
            return new Messenger(in);
        }

        @Override
        public Messenger[] newArray(int size)
        {
            return new Messenger[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeList(this.list);
    }

    /**
     * @CreateTime 2022-02-27 13:11:44
     * @Description 构造函数
     */
    public Messenger()
    {}

    /**
     * @CreateTime 2022-06-09 16:57:00
     * @Description 构造函数
     */
    public Messenger(Parcel parcel)
    {
        parcel.readList(this.list, super.getClass().getClassLoader());
    }

    /**
     * @CreateTime 2022-02-27 13:11:56
     * @Description 构造函数
     */
    public Messenger(String type)
    {
        this.addMsg(type);
    }

    /**
     * @CreateTime 2022-03-12 18:16:01
     * @Description 构造函数
     */
    public Messenger(Messenger msg)
    {
        this(msg.list);
    }

    /**
     * @CreateTime 2022-03-05 21:24:02
     * @Description 构造函数
     */
    public Messenger(ArrayList<HashMap<String, String>> list)
    {
        if (list != null)
            this.list.addAll(list);
    }

    /**
     * @CreateTime 2022-04-16 09:42:48
     * @Description 新建一个对象
     */
    public static Messenger newObject()
    {
        return Messenger.newObject(null);
    }

    /**
     * @CreateTime 2022-03-19 16:15:27
     * @Description 新建一个对象
     */
    public static Messenger newObject(ArrayList<HashMap<String, String>> data)
    {
        return new Messenger(data);
    }

    /**
     * @CreateTime 2022-04-16 20:06:38
     * @Description 克隆
     */
    public Messenger cloneObject()
    {
        return Messenger.newObject(this.getList());
    }

    /**
     * @CreateTime 2022-03-05 20:40:38
     * @Description 获取Msg
     */
    public String getString(String tag)
    {
        return this.getString(tag, "0");
    }

    /**
     * @CreateTime 2022-04-04 15:55:25
     * @Description 获取Msg
     */
    public String getString(int index, String tag)
    {
        return this.getString(index, tag, "0");
    }

    /**
     * @CreateTime 2022-04-04 15:52:25
     * @Description 获取Msg
     */
    public String getString(int index, String tag, String devalue)
    {
        return this.list.size() > index ? (this.list.get(index).containsKey(tag) ? this.list.get(index).get(tag) : devalue) : devalue;
    }

    /**
     * @CreateTime 2022-02-19 11:38:54
     * @Description 获取Msg
     */
    public String getString(String tag, String devalue)
    {
        StringBuilder data = new StringBuilder();

        for (String msg : this.getList(tag))
            data.append(msg);

        return data.length() > 0 ? data.toString() : devalue;
    }

    /**
     * @CreateTime 2022-03-05 21:13:09
     * @Description 获取Msg
     */
    public long getLong(String tag)
    {
        try
        {
            return Long.parseLong(this.getString(tag));
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    /**
     * @CreateTime 2022-04-04 15:50:43
     * @Description 获取Msg
     */
    public long getLong(int index, String tag)
    {
        try
        {
            return Long.parseLong(this.list.get(index).get(tag));
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    /**
     * @CreateTime 2022-03-05 11:01:17
     * @Description 获取全部Msg
     */
    public ArrayList<HashMap<String, String>> getList()
    {
        return this.list;
    }

    /**
     * @CreateTime 2023-01-15 23:30:43
     * @Description 获取一个列表的消息
     */
    public HashMap<String, String> getList(int index)
    {
        return index < 0 || index >= this.list.size() ? new HashMap<>() : this.list.get(index);
    }

    /**
     * @CreateTime 2022-02-19 11:56:07
     * @Description 获取全部消息
     */
    public ArrayList<String> getList(String tag)
    {
        ArrayList<String> list = new ArrayList<>();

        for (HashMap<String, String> map : this.list)
            if (map.containsKey(tag))
                list.add(map.get(tag));

        return list;
    }

    /**
     * @CreateTime 2022-04-17 00:44:04
     * @Description 获取列表数量
     */
    public int getListSize()
    {
        return this.list.size();
    }

    /**
     * @CreateTime 2022-02-19 14:45:06
     * @Description 获取Msg数量
     */
    public int getMsgSize()
    {
        int size = 0;

        for (HashMap<String, String> map : this.list)
            size += map.size();

        return this.list.size() * size;
    }

    /**
     * @CreateTime 2022-05-01 14:35:55
     * @Description 获取Msg数量
     */
    public int getMsgSize(String tag)
    {
        int count = 0;

        for (HashMap<String, String> map : this.list)
            if (map.containsKey(tag))
                count++;

        return count;
    }

    /**
     * @CreateTime 2022-02-20 00:26:14
     * @Description 存在消息Tag
     */
    public boolean hasMsg(String tag)
    {
        for (HashMap<String, String> map : this.list)
            if (map.containsKey(tag))
                return true;

        return false;
    }

    /**
     * @CreateTime 2022-04-30 22:27:24
     * @Description 插入消息
     */
    public Messenger insert(int index, String tag, String value)
    {
        if (index > -1 && index < this.list.size())
            this.list.get(index).put(tag, value);

        return this;
    }

    /**
     * @CreateTime 2022-04-02 20:28:01
     * @Description 增加消息
     */
    public Messenger addMsg(Messenger msg)
    {
        if (msg != null)
            this.addMsg(msg.list);

        return this;
    }

    /**
     * @CreateTime 2022-04-30 22:30:31
     * @Description 增加消息
     */
    public Messenger addMsg(Map<String, String> map)
    {
        if (map != null)
            for (Map.Entry<String, String> entry : map.entrySet())
                this.addMsg(entry.getKey(), entry.getValue());

        return this;
    }

    /**
     * @CreateTime 2022-03-12 21:19:11
     * @Description 增加消息
     */
    public Messenger addMsg(ArrayList<HashMap<String, String>> data)
    {
        this.list.addAll(data);

        return this;
    }

    /**
     * @CreateTime 2022-03-05 07:07:44
     * @Description 增加消息类型
     */
    public Messenger addMsg(String type)
    {
        return this.addMsg(type, type);
    }

    /**
     * @CreateTime 2022-02-19 11:58:00
     * @Description 增加消息
     */
    public Messenger addMsg(String tag, String value)
    {
        if (tag == null || tag.isEmpty() || value == null)
            return this;

        for (HashMap<String, String> map : this.list)//参与引索列表消息追加
            if (!map.containsKey(tag))
            {
                map.put(tag, value);
                return this;
            }

        HashMap<String, String> map = new HashMap<>();
        map.put(tag, value);

        this.list.add(map);

        return this;
    }

    /**
     * @CreateTime 2022-05-02 21:54:33
     * @Description 增加消息
     */
    public Messenger addMsg(String tag, String... value)
    {
        StringBuilder append = new StringBuilder();

        for (String s : value)
            append.append(s);

        return this.addMsg(tag, append.toString());
    }

    /**
     * @CreateTime 2022-03-05 21:08:05
     * @Description 增加消息
     */
    public Messenger addMsg(String tag, Object value)
    {
        if (value != null)
            this.addMsg(tag, value.toString());

        return this;
    }

    /**
     * @CreateTime 2022-02-19 12:01:19
     * @Description 清除消息
     */
    public Messenger clearMsg(String tag)
    {
        for (HashMap<String, String> map : this.list)
            map.remove(tag);

        return this;
    }

    /**
     * @CreateTime 2022-02-19 12:03:40
     * @Description 清除全部消息
     */
    public Messenger clearMsg()
    {
        this.list.clear();

        return this;
    }

    /**
     * @CreateTime 2022-02-19 12:07:12
     * @Description 格式化
     */
    @Override
    public String toString()
    {
        return this.list.toString();
    }

    /**
     * @CreateTime 2022-03-12 18:38:53
     * @Description 消息构造者
     */
    public interface Builder
    {
        void build(Messenger msg);
    }
}