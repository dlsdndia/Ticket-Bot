package hwang.macro

import hwang.macro.config.IntroConfig

fun main() {
    // IntroConfig 인스턴스 생성
    val introConfig = IntroConfig()

    // IntroConfig에서 ASCII 아트 출력
    introConfig.printTicketBotArt()

    // 이후 추가 작업을 위한 메시지 출력
    println("Press Enter to continue...")
    readlnOrNull() // 사용자 입력 대기
}