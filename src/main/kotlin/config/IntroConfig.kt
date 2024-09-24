package hwang.macro.config

class IntroConfig {

    // ANSI 코드로 색상 설정
    private val RED = "\u001B[31m" // 빨간색
    private val RESET = "\u001B[0m" // 색상 리셋

    // TICKET BOT ASCII 아트를 저장하는 변수
    val ticketBotArt = """
████████╗██╗░█████╗░██╗░░██╗███████╗████████╗  ██████╗░░█████╗░████████╗
╚══██╔══╝██║██╔══██╗██║░██╔╝██╔════╝╚══██╔══╝  ██╔══██╗██╔══██╗╚══██╔══╝
░░░██║░░░██║██║░░╚═╝█████═╝░█████╗░░░░░██║░░░  ██████╦╝██║░░██║░░░██║░░░
░░░██║░░░██║██║░░██╗██╔═██╗░██╔══╝░░░░░██║░░░  ██╔══██╗██║░░██║░░░██║░░░
░░░██║░░░██║╚█████╔╝██║░╚██╗███████╗░░░██║░░░  ██████╦╝╚█████╔╝░░░██║░░░
░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚═╝╚══════╝░░░╚═╝░░░  ╚═════╝░░╚════╝░░░░╚═╝░░░
    """.trimIndent()

    // ASCII 아트와 추가 문자열 출력 함수
    fun printTicketBotArt() {
        println(ticketBotArt)
        println("$RED Version - 1.0.0 made by Hwang Inwoo $RESET")
    }

    // LICENSE 파일에서 3줄만 출력하는 함수
    fun printLicenseSnippet() {
        val licensePath = IntroConfig::class.java.getResource("/LICENSE.txt")?.readText()
        val licenseLines = licensePath?.lines()?.take(3) ?: listOf("LICENSE not found")
        val titleLine = "─".repeat(ticketBotArt.lines().first().length)

        println(titleLine)
        println("LICENSE")
        println(titleLine)
        licenseLines.forEach { println(it) }
        println(titleLine)
    }

    // README 파일에서 <!-- intro --> 섹션만 출력하는 함수
    fun printReadmeIntro() {
        val readmePath = IntroConfig::class.java.getResource("/README.md")?.readText()
        val introSection = extractSection(readmePath ?: "README not found", "intro")
        val titleLine = "─".repeat(ticketBotArt.lines().first().length)

        println(titleLine)
        println("README INTRO")
        println(titleLine)
        println(introSection)
        println(titleLine)
    }

    // README에서 특정 섹션을 추출하는 함수
    fun extractSection(readmeContent: String, section: String): String {
        val startTag = "<!-- $section -->"
        val endTag = "<!-- /$section -->"

        // 시작 태그와 종료 태그 사이의 내용 추출
        val startIndex = readmeContent.indexOf(startTag)
        val endIndex = readmeContent.indexOf(endTag, startIndex)

        // 해당 구역이 있으면 추출
        return if (startIndex != -1 && endIndex != -1) {
            readmeContent.substring(startIndex + startTag.length, endIndex).trim()
        } else {
            "Section not found"
        }
    }
}