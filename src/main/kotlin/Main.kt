package hwang.macro

import hwang.macro.manager.IntroManager
import hwang.macro.manager.SiteManager

fun main() {
    // IntroConfig 인스턴스 생성
    val introManager = IntroManager()
    // SiteManager 인스턴스 생성
    val siteManager = SiteManager()

    // IntroConfig에서 ASCII 아트 출력
    introManager.printTicketBotArt()

    // 이후 추가 작업을 위한 메시지 출력
    println("Press Enter to continue...")
    readlnOrNull() // 사용자 입력 대기

    // 사이트 선택 기능 호출
    val selectedSite = siteManager.selectSiteWithArrowKeys()
    println("You have selected: $selectedSite")

}
