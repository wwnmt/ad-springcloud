package edu.nuaa.wwn.ad.service;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.SearchTestApplication;
import edu.nuaa.wwn.ad.search.ISearch;
import edu.nuaa.wwn.ad.search.vo.SearchRequest;
import edu.nuaa.wwn.ad.search.vo.feature.DistrictFeature;
import edu.nuaa.wwn.ad.search.vo.feature.FeatureRelation;
import edu.nuaa.wwn.ad.search.vo.feature.ItFeature;
import edu.nuaa.wwn.ad.search.vo.feature.KeywordFeature;
import edu.nuaa.wwn.ad.search.vo.media.AdSlot;
import edu.nuaa.wwn.ad.search.vo.media.App;
import edu.nuaa.wwn.ad.search.vo.media.Device;
import edu.nuaa.wwn.ad.search.vo.media.Geo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-09-01
 * Time: 11:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SearchTestApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SearchServiceTest {

    @Autowired
    private ISearch search;

    @Test
    public void testFetchAds() {
        SearchRequest request = new SearchRequest();
        request.setMediaId("wwn&kk");

        //1
        request.setRequestInfo(new SearchRequest.RequestInfo(
                "kk",
                Collections.singletonList(new AdSlot(
                        "ad-x", 1, 1080, 720, Arrays.asList(1,2), 1000
                )),
                buildExampleApp(),
                buildExampleGeo(),
                buildExampleDevice()
        ));
        request.setFeatureInfo(buildExampleFeatureInfo(
                Arrays.asList("宝马", "大众"),
                Collections.singletonList(
                        new DistrictFeature.ProvinceAndCity(
                                "安徽省", "合肥市"
                        )),
                Arrays.asList("台球", "游泳"),
                FeatureRelation.OR
        ));
        System.out.println(JSON.toJSONString(request));
        System.out.println(JSON.toJSONString(search.fetchAds(request)));
    }

    private App buildExampleApp() {
        return new App("wwn", "kk", "wwn.kk", "video");
    }

    private Geo buildExampleGeo() {
        return new Geo((float) 100.28, (float) 12.32,
                       "江苏省", "南京市");
    }

    private Device buildExampleDevice() {
        return new Device(
                "iphone",
                "0xxxx",
                "127.0.0.1",
                "x",
                "1080 720",
                "1080 720",
                "1996121"
        );
    }

    private SearchRequest.FeatureInfo buildExampleFeatureInfo(
        List<String> keywords,
        List<DistrictFeature.ProvinceAndCity> provinceAndCities,
        List<String> its,
        FeatureRelation relation) {
        return new SearchRequest.FeatureInfo(
                new KeywordFeature(keywords),
                new DistrictFeature(provinceAndCities),
                new ItFeature(its),
                relation
        );
    }
}
