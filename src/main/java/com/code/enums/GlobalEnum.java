package com.code.enums;

/**
 * 全局枚举信息
 *
 * @author weiQiang
 */
public enum GlobalEnum {

    /**
     * 全局状态信息
     */
    QuerySuccess("查询成功!"),

    QueryError("查询失败!"),

    InsertSuccess("增加成功!"),

    InsertError("增加失败!"),

    ImportSuccess("导入成功!"),

    ImportError("导入失败!"),

    DataEmpty("数据为空!"),

    DeleteSuccess("删除成功!"),

    DeleteError("删除失败!"),

    FileEmpty("文件信息为空!"),

    DeleteNoSupport("删除不被允许!"),

    UpdateSuccess("更新成功!"),

    UpdateError("更新失败!"),

    SendSuccess("发送成功!"),

    SendError("发送成功!"),

    ServerUsed("服务忙，请稍后重试!"),

    PkIdEmpty("主键ID为空!"),

    ExceptionMessage("发生了错误:%s"),

    MsgOperationSuccess("操作成功"),

    MsgOperationFailed("操作失败"),

    LogSysNoOpen("日志系统未开启"),
    ;


    private String message;

    GlobalEnum(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


}
