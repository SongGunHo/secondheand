package org.koreait.admin.global.menus;

import org.koreait.admin.global.golal.menus.Menu;
import org.koreait.admin.global.search.ListDate;
import org.koreait.admin.member.controllers.MemberSearch;

import java.lang.reflect.Member;
import java.util.*;

public class Menus {
    private static Map<String, List<Menu>> menus = new HashMap<>();

    static {
        // 사이트 설정 메뉴
        menus.put("config", List.of(
                new Menu("basic", "기본설정", "/admin/config"),
                new Menu("terms", "약관설정", "/admin/config/terms")
        ));

        // 회원 관리 메뉴
        menus.put("member", List.of(
                new Menu("list", "회원목록", "/admin/member")
        ));

        // 상품 등록
        menus.put("product ", List.of(
                new Menu("List", "상품등록")
        ))

        // 트렌드 관리 메뉴
        menus.put("trend", List.of(
                new Menu("news", "뉴스", "/admin/trend"),
                new Menu("etc", "기타", "/admin/trend/etc")
        ));
    }

    /**
     * 주 메뉴 코드로 서브 메뉴를 조회
     *
     * @param mainCode
     * @return
     */
    public static List<Menu> getMenus(String mainCode) {
        return menus.getOrDefault(mainCode, List.of());
    }
}
    public ListDate<Member> getList(MemberSearch search){
    int page = Math.max(search.getPage(), 1);
    int limit = search.getLimit;
    limit = limit < 1 ? 20 : limit;
    int offset = (page -1) *limit;

    List<String> addWhere = new ArrayList<>();
    List<Object> params= new ArrayList<>();

    params.add(offset);
    params.add(limit);

    StringBuffer sb  = new StringBuffer(2000);
    sb.append( "SELECT * FORM MEMBER");
    sb.append("ORDER BY createdAt DESC");
    sb.append("LIMIT");

    List<Member> items=



    }