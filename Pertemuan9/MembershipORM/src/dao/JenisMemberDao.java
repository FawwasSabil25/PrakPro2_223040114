package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.JenisMember;

public class JenisMemberDao {
     private final SqlSessionFactory sqlSessionFactory;

    public JenisMemebrDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.insert("mapper.jenisMemberMapper.insert", jenisMember);
        }
        return result;
    }

    public int update(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.update("mapper.jenisMemberMapper.update", jenisMember);
        }
        return result;
    }

    public int delete(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.delete("mapper.jenisMemberMapper.delete", jenisMember);
        }   
        return result;
    }

    public List<JenisMember> findAll(){
        List<JenisMember> result;
        try(SqlSqssion session = sqlSessionFactory.openSession()){
            result = session.selectList("mapper.jenisMemberMapper.findAll");
        }
        return result;
    }
}
