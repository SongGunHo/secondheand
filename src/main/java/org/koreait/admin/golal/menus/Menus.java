package org.koreait.admin.golal.menus;

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
                new Menu("list", "회원목록", "/admin/member")
        ));

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