package easymapper.core;

import java.sql.ResultSet;

/**
 * 数据库操作管理器
 */
public interface IIOManager {

    ResultSet query(String sql);

    ResultSet update(String sql);
}
