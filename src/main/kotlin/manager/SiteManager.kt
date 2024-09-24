package hwang.macro.manager

import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.terminal.Terminal
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
        // 터미널 생성
        val terminal: Terminal = TerminalBuilder.builder()
            .jna(true) // JNA를 통해 터미널의 고급 기능을 활성화
            .system(true) // 기본 시스템 터미널 사용
            .build()

        // LineReader 생성
        val reader: LineReader = LineReaderBuilder.builder()
            .terminal(terminal)
            .build()

        var selectedIndex = 0

        while (true) {
            // 현재 선택 상태를 표시
            terminal.writer().print("\nUse Arrow Keys to select a site and press Enter:\n")
            for ((index, site) in sites.withIndex()) {
                if (index == selectedIndex) {
                    terminal.writer().print("> $site\n") // 선택된 항목에 표시
                } else {
                    terminal.writer().print("  $site\n")
                }
            }
            terminal.flush()

            // 키 입력을 대기
            val input = reader.readLine("", "", null as? String?, null)

            // ANSI escape code로 방향키 처리
            when (input) {
                "\u001B[A" -> { // Up Arrow Key (ANSI escape code)
                    selectedIndex = (selectedIndex - 1 + sites.size) % sites.size
                }
                "\u001B[B" -> { // Down Arrow Key
                    selectedIndex = (selectedIndex + 1) % sites.size
                }
                "" -> { // Enter Key (빈 입력)
                    return sites[selectedIndex]
                }
                else -> terminal.writer().println("Unsupported input: $input")
            }
        }
    }
}