package hwang.macro.manager

import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder

// 사이트와 관련된 모든 기능을 관리하는 클래스
class SiteManager {
    private val sites = listOf(
        "티켓링크(www.ticketlink.co.kr)",
        "인터파크(tickets.interpark.com)"
    )

    val ticketLinkAddr = "https://www.ticketlink.co.kr/home"
    val interparkAddr = "https://tickets.interpark.com"

    // 사이트 선택 기능
    fun selectSiteWithArrowKeys(): String {
        val terminal = TerminalBuilder.terminal()
        val reader = LineReaderBuilder.builder()
            .terminal(terminal)
            .build()

        var selectedIndex = 0

        while (true) {
            println("\nUse Arrow Keys to select a site and press Enter:")
            for ((index, site) in sites.withIndex()) {
                if (index == selectedIndex) {
                    println("> $site") // 선택된 항목에 표시
                } else {
                    println("  $site")
                }
            }

            when (val key = reader.readCharacter()) {
                65 -> { // Up Arrow Key
                    selectedIndex = (selectedIndex - 1 + sites.size) % sites.size
                }
                66 -> { // Down Arrow Key
                    selectedIndex = (selectedIndex + 1) % sites.size
                }
                13 -> { // Enter Key
                    return sites[selectedIndex]
                }
                else -> println("Unsupported key: $key")
            }
        }
    }
}
