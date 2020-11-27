package easymapper.core;

/**
 * EasyMapper加载中心
 */
public interface ILoadCenter {

    /**
     * 扫描Mapper所在包
     * @param path Mapper所在包路径
     */
    void scanMapper(String path);

    /**
     * 扫描MapperBean所在包
     * @param path MapperBean所在包路径
     */
    void scanMapperBean(String path);

    /**
     * 获取数据库中一张表的所有列名
     * @param table 表名
     * @return 所有列名
     */
    String[] getTableColName(String table);
}
