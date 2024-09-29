package hwang.macro

import hwang.macro.manager.IntroManager
import java.awt.event.KeyEvent
import java.io.File
import javax.swing.JFrame
import javax.swing.KeyStroke

// ANSI 코드로 색상 설정
const val GREEN = "\u001B[32m" // 초록색
const val RESET = "\u001B[0m" // 색상 리셋

fun main() {
    // IntroConfig 인스턴스 생성
    val introManage = IntroManager()

    // ASCII 아트 및 타이틀 출력
    println()
    println()
    println()
    introManage.printTicketBotArt()
    println() // 한 줄 띄우기
    println()

    // 메뉴 바 ASCII 아트 생성
    printMenuBar()
    println() // 한 줄 띄우기

    // JFrame을 사용하여 키 입력 감지
    val frame = JFrame()
    frame.isUndecorated = true // 창 표시 안 함
    frame.setSize(0, 0) // 최소 크기로 설정
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE // 종료 설정

    // F10 키를 누르면 LICENSE 출력
    frame.rootPane.inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "F10")
    frame.rootPane.actionMap.put("F10", object : javax.swing.AbstractAction() {
        override fun actionPerformed(e: java.awt.event.ActionEvent?) {
            println("\n\n[F10 Pressed] Displaying LICENSE Information:")
            introManage.printLicenseSnippet()
        }
    })

    // F11 키를 누르면 README 출력
    frame.rootPane.inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "F11")
    frame.rootPane.actionMap.put("F11", object : javax.swing.AbstractAction() {
        override fun actionPerformed(e: java.awt.event.ActionEvent?) {
            println("\n\n[F11 Pressed] Displaying README Information:")
            introManage.printReadmeIntro()
        }
    })

    // 창을 보이지 않게 표시하여 키 입력 감지 시작
    frame.isVisible = true

    // 이후 추가 작업을 위한 메시지 출력
    println("$GREEN Press Enter to continue... $RESET")

    // 사용자 입력 대기 (엔터 키 입력 대기)
    readlnOrNull()

    // 프로그램 종료 후 JFrame 닫기
    frame.dispose()
    println("\nTICKET BOT is now ready!")
}

// 메뉴 바를 ASCII 아트로 생성하는 함수
fun printMenuBar() {
    println("╔═════════════════════════════════════════════╗")
    println("║                 INFORMATION                 ║")
    println("╚═════════════════════════════════════════════╝")
    println(" - Press [F10] to view LICENSE                ")
    println(" - Press [F11] to view README                 ")
}