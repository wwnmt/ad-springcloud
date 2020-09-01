package edu.nuaa.wwn.ad.search;

import edu.nuaa.wwn.ad.search.vo.SearchRequest;
import edu.nuaa.wwn.ad.search.vo.SearchResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 17:41
 */
public interface ISearch {

    SearchResponse fetchAds(SearchRequest request);
}
