package io.renren.factory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: gxz gongxuanzhang@foxmail.com
 **/

@Component
public class MongoDBCollectionFactory {

    private final String TABLE_NAME_KEY = "tableName";
    private final String LIMIT_KEY = "limit";
    private final String OFFSET_KEY = "offset";



    @Autowired
    private MongoDatabase mongoDatabase;

    /***
     * 通过表名获得查询对象
     * @author gxz
     * @date  2020/5/9
     * @param collectionName mongo的集合名(表名)
     * @return 连接查询对象
     **/
    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoDatabase.getCollection(collectionName);
    }

    /***
     * 获得当前数据库的集合名称
     * 注: mongo相对关系型数据库较为特殊，查询表名无法分页，用stream实现
     * @author gxz
     * @date  2020/5/9
     * @param map 这是查询条件 和关系型数据库一致
     * @return 集合名称
     **/
    public List<String> getCollectionNames(Map<String, Object> map) {
        int limit = Integer.valueOf(map.get(LIMIT_KEY).toString());
        int skip = Integer.valueOf(map.get(OFFSET_KEY).toString());
        List<String> names;
        if (map.containsKey(TABLE_NAME_KEY)) {
            names = getCollectionNames(map.get(TABLE_NAME_KEY).toString());
        } else {
            names = getCollectionNames();
        }
        return names.stream().skip(skip).limit(limit).collect(Collectors.toList());
    }
    /***
     * 获得集合名称总数(表的数量) 为了适配MyBatisPlus的分页插件 提供方法
     * @author gxz
     * @date  2020/5/9
     * @param map 这是查询条件 和关系型数据库一致
     * @return int
     **/
    public int getCollectionTotal(Map<String, Object> map) {
        if (map.containsKey(TABLE_NAME_KEY)) {
            return getCollectionNames(map.get(TABLE_NAME_KEY).toString()).size();
        }
        return getCollectionNames().size();

    }


    private List<String> getCollectionNames() {
        MongoIterable<String> names = mongoDatabase.listCollectionNames();
        List<String> result = new ArrayList<>();
        for (String name : names) {
            result.add(name);
        }
        return result;
    }

    private List<String> getCollectionNames(String likeName) {
        return getCollectionNames()
                .stream()
                .filter((name) -> name.contains(likeName)).collect(Collectors.toList());
    }
}
