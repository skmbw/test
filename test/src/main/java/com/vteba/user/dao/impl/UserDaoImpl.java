package com.vteba.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vteba.tx.jdbc.spring.SpringJdbcTemplate;
import com.vteba.tx.jdbc.spring.impl.SpringGenericDaoImpl;
import com.vteba.tx.jdbc.spring.impl.SqlType;
import com.vteba.user.dao.UserDao;
import com.vteba.user.model.EmpUser;
import com.vteba.user.model.User;

/**
 * UserDao实现
 * @author  yinlei 
 * @since 2014-7-4
 */
@Repository
public class UserDaoImpl extends SpringGenericDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Autowired
    @Override
    public void setSpringJdbcTemplate(SpringJdbcTemplate skmbwJdbcTemplate) {
        this.springJdbcTemplate = skmbwJdbcTemplate;
    }

    @Override
    public Object mapRows(ResultSet rs, String sql, Class<?> clazz) throws SQLException {
        if (clazz == User.class) {
            return mapRows(rs, 0);
        } else if (clazz == EmpUser.class) {
            EmpUser empUser = new EmpUser();
            empUser.setAge(rs.getInt("age"));
            empUser.setUserName(rs.getString("user_name"));
            return empUser;
        }
        return null;
    }

    @Override
    public User mapRows(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserName(rs.getString("user_name"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        user.setId(rs.getLong("id"));
        user.setPassword(rs.getString("password"));
        user.setState(rs.getBoolean("state"));
        return user;
    }

//    @Override
//    public Map<String, Object> mapBean(User entity, SqlType sqlType) {
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        
//        StringBuilder columns = new StringBuilder();
//        boolean append = true;
//        
//        if (entity != null) {
//            switch (sqlType) {
//                case INSERT:// 对于insert语句根本不需要考虑，是否要前缀
//                    columns.append("insert into ").append(tableName).append("(");
//                    
//                    StringBuilder holders = new StringBuilder(") values(");
//                    
//                    if (entity.getUserName() != null) {
//                        resultMap.put("user_name", entity.getUserName());
//                        columns.append("user_name,");
//                        holders.append(":user_name,");
//                    }
//                    if (entity.getAge() != null) {
//                        resultMap.put("age", entity.getAge());
//                        columns.append("age,");
//                        holders.append(":age,");
//                    }
//                    if (entity.getId() != null) {// 这个id属性，如果数据库自动生成主键，可能不需要
//                        resultMap.put("id", entity.getId());
//                        columns.append("id,");
//                        holders.append(":id,");
//                    }
//                    if (entity.getEmail() != null) {
//                        resultMap.put("email", entity.getEmail());
//                        columns.append("email,");
//                        holders.append(":email,");
//                    }
//                    if (entity.getPassword() != null) {
//                        resultMap.put("password", entity.getPassword());
//                        columns.append("password,");
//                        holders.append(":password,");
//                    }
//                    resultMap.put("state", entity.isState() ? 1 : 0);
//                    columns.append("state");
//                    holders.append(":state");
//                    
//                    columns.append(holders).append(")");
//                    resultMap.put(SQL_KEY, columns.toString());
//                    break;
//                case SELECT:
//                    columns.append("select * from ").append(tableName);
//                    
//                    buildWhere(entity, resultMap, columns, append);
//                    break;
//                case DELETE:
//                    columns.append("delete from ").append(tableName);
//                    
//                    buildWhere(entity, resultMap, columns, append);
//                    break;
//                case UPDATE:
//                    columns.append("update ").append(tableName);
//                    if (entity.getUserName() != null) {
//                        resultMap.put("user_name", entity.getUserName());
//                        columns.append(" set user_name = :user_name");
//                        append = false;
//                    }
//                    if (entity.getAge() != null) {
//                        resultMap.put("age", entity.getAge());
//                        if (append) {
//                            columns.append(" set age = :age");
//                            append = false;
//                        } else {
//                            columns.append(", age = :age");
//                        }
//                    }
//                    if (entity.getEmail() != null) {
//                        resultMap.put("email", entity.getEmail());
//                        if (append) {
//                            columns.append(" set email = :email");
//                            append = false;
//                        } else {
//                            columns.append(", email = :email");
//                        }
//                    }
//                    if (entity.getPassword() != null) {
//                        resultMap.put("password", entity.getPassword());
//                        if (append) {
//                            columns.append(" set password = :password");
//                            append = false;
//                        } else {
//                            columns.append(", password = :password");
//                        }
//                    }
//                    
//                    resultMap.put("state", entity.isState() ? 1 : 0);
//                    if (append) {
//                        columns.append(" set state = :state");
//                        append = false;
//                    } else {
//                        columns.append(", state = :state");
//                    }
//                    
//                    if (entity.getId() != null) {
//                        resultMap.put("id", entity.getId());
//                    } else {
//                        throw new NullPointerException("update方法是根据ID更新实体，ID属性为空，请设置ID属性值；要么使用updateBatch。");
//                    }
//                    columns.append(" where id = :id");
//                    
//                    resultMap.put(SQL_KEY, columns.toString());
//                    break;
//                case WHERE:
//                    buildWhere(entity, resultMap, columns, append);
//                    break;
//                case UPDATESET:
//                    columns.append("update ").append(tableName);
//                    if (entity.getUserName() != null) {
//                        resultMap.put("_user_name", entity.getUserName());
//                        columns.append(" set user_name = :_user_name");
//                        append = false;
//                    }
//                    if (entity.getAge() != null) {
//                        resultMap.put("_age", entity.getAge());
//                        if (append) {
//                            columns.append(" set age = :_age");
//                            append = false;
//                        } else {
//                            columns.append(", age = :_age");
//                        }
//                    }
//                    if (entity.getEmail() != null) {
//                        resultMap.put("_email", entity.getEmail());
//                        if (append) {
//                            columns.append(" set email = :_email");
//                            append = false;
//                        } else {
//                            columns.append(", email = :_email");
//                        }
//                    }
//                    if (entity.getPassword() != null) {
//                        resultMap.put("_password", entity.getPassword());
//                        if (append) {
//                            columns.append(" set password = :_password");
//                            append = false;
//                        } else {
//                            columns.append(", password = :_password");
//                        }
//                    }
//                    
//                    resultMap.put("_state", entity.isState() ? 1 : 0);
//                    if (append) {
//                        columns.append(" set state = :_state");
//                        append = false;
//                    } else {
//                        columns.append(", state = :_state");
//                    }
//                    resultMap.put(SQL_KEY, columns.toString());
//                    break;
//                case NULL:
//
//                default:
//                    if (entity.getUserName() != null) {
//                        resultMap.put("user_name", entity.getUserName());
//                    }
//                    if (entity.getAge() != null) {
//                        resultMap.put("age", entity.getAge());
//                    }
//                    if (entity.getId() != null) {
//                        resultMap.put("id", entity.getId());
//                    }
//                    if (entity.getEmail() != null) {
//                        resultMap.put("email", entity.getEmail());
//                    }
//                    if (entity.getPassword() != null) {
//                        resultMap.put("password", entity.getPassword());
//                    }
//                    resultMap.put("state", entity.isState() ? 1 : 0);
//                    break;
//            }
//        }
//        return resultMap;
//    }

    protected void buildWhere(User entity, Map<String, Object> resultMap, StringBuilder columns, boolean append) {
        if (entity.getUserName() != null) {
            resultMap.put("user_name", entity.getUserName());
            columns.append(" where user_name = :user_name");
            append = false;
        }
        if (entity.getAge() != null) {
            resultMap.put("age", entity.getAge());
            if (append) {
                columns.append(" where age = :age");
                append = false;
            } else {
                columns.append(" and age = :age");
            }
        }
        if (entity.getEmail() != null) {
            resultMap.put("email", entity.getEmail());
            if (append) {
                columns.append(" where email = :email");
                append = false;
            } else {
                columns.append(" and email = :email");
            }
        }
        if (entity.getPassword() != null) {
            resultMap.put("password", entity.getPassword());
            if (append) {
                columns.append(" where password = :password");
                append = false;
            } else {
                columns.append(" and password = :password");
            }
        }
        
        resultMap.put("state", entity.isState() ? 1 : 0);
        if (append) {
            columns.append(" where state = :state");
            append = false;
        } else {
            columns.append(" and state = :state");
        }
        
        if (entity.getId() != null) {
            String column = "id";
            resultMap.put(column, entity.getId());
            if (append) {
                columns.append(" where id = :id").append(column);
            } else {
                columns.append(" and id = :id");
            }
        }
        resultMap.put(SQL_KEY, columns.toString());
    }

    public Map<String, Object> mapBean(Object entity) {
    	Map<String, Object> resultMap = new HashMap<>();
    	if (entity instanceof User) {
    	    resultMap = mapBean((User) entity, SqlType.NULL);
    	} else if (entity instanceof EmpUser) {
    		EmpUser user = (EmpUser) entity;
    		if (user.getAge() != null) {
    			resultMap.put("age", user.getAge());
    		}
    		if (user.getUserName() != null) {
    			resultMap.put("user_name", user.getUserName());
    		}
    	}
    	
    	return resultMap;
    }
}
