package hwang.macro.manager

// 사이트와 관련된 모든 기능을 관리하는 클래스
class SiteManager {
    private val sites = listOf(
        "티켓링크(www.ticketlink.co.kr)",
        "인터파크(tickets.interpark.com)"
    )

    val ticketLinkAddr = "https://www.ticketlink.co.kr/home"
    val interparkAddr = "https://tickets.interpark.com"

    // 사이트 선택 기능
    fun selectSiteWithNumberInput(): String {
        var selectedIndex: Int? = null

        while (selectedIndex == null) {
            // 사이트 목록 표시
            println("사이트를 선택하세요:")
            for ((index, site) in sites.withIndex()) {
                println("${index + 1}. $site")
            }
            print("번호를 입력하고 Enter를 누르세요: ")

            // 사용자 입력을 처리
            val input = readLine()
            selectedIndex = try {
                val number = input?.toInt() ?: -1
                if (number in 1..sites.size) number - 1 else null
            } catch (e: NumberFormatException) {
                null
            }

            if (selectedIndex == null) {
                println("잘못된 입력입니다. 다시 시도하세요.")
            }
        }

        return sites[selectedIndex]
    }
}


