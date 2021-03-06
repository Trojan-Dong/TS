package elastic;

import com.alibaba.fastjson.JSON;
import com.trojan.one.entity.User;
import com.trojan.two.OneApp;
import com.trojan.two.config.ElasticSearchConfig;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OneApp.class})
public class ElasticSearchDemoTest {
    @Resource
    private ElasticSearchConfig elasticSearchConfig;
    @Resource
    private RestHighLevelClient client;

    /**
     * ??????ES??????????????????spring????????????
     */
    @Test
    public void contextLoads() {
        System.out.println(elasticSearchConfig);
    }

    /**
     * ??????????????????
     */
    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("wlp-index");//?????????????????????
        indexRequest.id("101");
        User user = new User();
        user.setUsername("hhh");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);//???????????????????????????
        /**
         * ElasticSearchConfig.COMMON_OPTIONS:??????????????????????????????,?????????RequestOptions.DEFAULT
         */
        //????????????
        try {
            IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
            //??????????????????
            System.out.println(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * ??????????????????
     */
    @Test
    public void testBulkIndexDocument() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        List<User> documents = new ArrayList<>();
        User userOne = new User();
        User userTwo = new User();
        User userThree = new User();
        documents.add(userOne);
        documents.add(userTwo);
        documents.add(userThree);
        documents.forEach(doc -> {
            //????????????IndexRequest().id()????????????,??????????????????
            bulkRequest.add(new IndexRequest("wlp-index").source(JSON.toJSONString(doc), XContentType.JSON));
        });
        BulkResponse bulk = client.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);
        //bulk.hasFailures():????????????
        System.out.println(bulk.hasFailures());
    }

    /**
     * ??????id??????????????????
     */
    @Test
    public void getDocumentById() throws IOException {
        GetRequest getRequest = new GetRequest("wlp-index", "100");
        GetResponse documentFields = client.get(getRequest, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(documentFields);
    }

    /**
     * ????????????(??????,???????????????)
     */
    @Test
    public void searchData() throws IOException {
        SearchRequest searchRequest = new SearchRequest("wlp-index");
        //searchRequest.indices("wlp-index");//??????????????????????????????????????????
        /**
         * ???????????? ??????????????????????????? ????????????????????? .keyword,??????????????????
         * ????????? QueryBuilders.termQuery("name.keyword","??????");
         * termQuery:???????????? matchQuery:????????????
         */
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("about.keyword", "?????????001");
        //??????????????????
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //?????? size:????????????(??????10) from?????????????????????
        searchSourceBuilder.size(20);
        searchSourceBuilder.from(0);
        searchSourceBuilder.query(queryBuilder);
        //????????????????????????
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        //????????????
        SearchHit[] hits = searchResponse.getHits().getHits();
        Arrays.stream(hits).forEach(documentFields -> {
            System.out.println(documentFields.getSourceAsMap());
        });
    }

    /**
     * ????????????
     */
    @Test
    public void testFuzzyQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("k*");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("OriginWeather", "Sunny"));
        //????????????
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse response = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
            SearchHit[] hits = response.getHits().getHits();
            Arrays.stream(hits).forEach(documentFields -> {
                System.out.println(documentFields.getSourceAsMap());
            });
        } catch (Exception e) {

        }

    }

    /**
     * ??????????????????????????????
     */
    @Test
    public void testIsDocumentExists() throws IOException {
        GetRequest request = new GetRequest("wlp-index", "101");
        //?????????source?????????
        request.fetchSourceContext(new FetchSourceContext(false));
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * ??????????????????????????????
     */
    @Test
    public void updateDocumentById() throws IOException {
        UpdateRequest request = new UpdateRequest("wlp-index", "101");
        //?????????????????????,es????????????
        User user = new User();
        user.setUsername("aaa");
        request.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse update = client.update(request, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(update);
    }


    /**
     * ??????id??????????????????
     */
    @Test
    public void deleteDocumentById() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("wlp-index", "100");
        DeleteResponse delete = client.delete(deleteRequest, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(delete);
    }

    //????????????
    @Test
    public void testHighlightSearch() throws IOException {
        //????????????
        SearchRequest searchRequest = new SearchRequest("wlp-index");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("about.keyword", "??????")) //????????????
                .timeout(new TimeValue(60, TimeUnit.SECONDS))
                .highlighter(new HighlightBuilder()
                        .field("about.keyword") //????????????
                        .requireFieldMatch(false) // ??????????????????
                        .preTags("<span style='coler:red'>")
                        .postTags("</span>"));
        //????????????
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //????????????
        List<Object> queryList = new LinkedList<>();
        for (SearchHit documentFields : search.getHits().getHits()) {
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();//???????????????
            HighlightField field = documentFields.getHighlightFields().get("name.keyword");
            //???????????????????????????????????????????????????????????????
            Text[] texts = field.fragments();
            String n_text = "";
            for (Text text : texts) {
                n_text += text;
            }
            sourceAsMap.put("name", n_text);//?????????????????????????????????
            queryList.add(sourceAsMap);

        }
        queryList.forEach(System.out::println);
    }

}
