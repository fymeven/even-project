package com.even.common.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.List;

/**
 * Created by fymeven on 2017/7/10.
 */
public class SolrSearchHelper {

    //solr服务器地址
    private static  String host="http://localhost:8983/solr";

    /**
     * 添加文档
     * @throws java.io.IOException
     * @throws org.apache.solr.client.solrj.SolrServerException
     */
    public static void modifyDocument() throws IOException, SolrServerException {
        String url=host+"/core01";
        SolrClient solrClient=new HttpSolrClient(url);
        SolrInputDocument document=new SolrInputDocument();
        document.addField("id",3);
        document.addField("title","solr测试标题");
        document.addField("text","solr测试内容");
        solrClient.add(document);
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 删除文档
     * @throws java.io.IOException
     * @throws org.apache.solr.client.solrj.SolrServerException
     */
    public static void deleteDocument() throws IOException, SolrServerException {
        String url=host+"/core01";
        SolrClient solrClient=new HttpSolrClient(url);
//        solrClient.deleteById("2");//通过id删除
//        solrClient.deleteByQuery("*;*");//通过查询条件查询， *:*表示删除所有
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 搜索文档
     * @throws java.io.IOException
     * @throws org.apache.solr.client.solrj.SolrServerException
     */
    public static void queryDocument() throws IOException, SolrServerException {
        String url=host+"/core01";
        SolrClient solrClient=new HttpSolrClient(url);
        SolrQuery query=new SolrQuery();
        query.set("q","*:*");//查询参数， *:* 查询所有
        //参数fq, 给query增加过滤查询条件
//        query.addFilterQuery("id:[0 TO 9]");//id为0-4
        //给query增加布尔过滤条件
        //query.addFilterQuery("description:演员");  //description字段中含有“演员”两字的数据
        //参数df,给query设置默认搜索域
//        query.set("df", "name");
        //参数sort,设置返回结果的排序规则
        query.setSort("id",SolrQuery.ORDER.asc);
        //分页查询参数
        query.setStart(0);
        query.setRows(10);
        //参数hl,设置高亮
        query.setHighlight(true);
        //设置高亮的字段
        query.addHighlightField("title");
        //设置高亮的样式
        query.setHighlightSimplePre("<font color='blue'>");
        query.setHighlightSimplePost("</font>");
        QueryResponse response=solrClient.query(query);
//        SolrDocumentList results = response.getResults();
        System.out.println("***************查询结果*****************");
//        System.out.println("总共查询到"+results.getNumFound()+"条数据");
//        for (SolrDocument result : results) {
//            System.out.println("id:"+result.get("id")+"\t"+"title:"+result.get("title")+"\t"+"text:"+result.get("text"));
//        }
        System.out.println("***************查询结果end*****************");
        //转换成实体bean
        List<SearchModel> searchModelList = response.getBeans(SearchModel.class);
        for (SearchModel searchModel : searchModelList) {
            System.out.println("id:"+searchModel.getId()+"\t"+"title:"+searchModel.getTitle()+"\t"+"text:"+searchModel.getText());
        }

    }
}