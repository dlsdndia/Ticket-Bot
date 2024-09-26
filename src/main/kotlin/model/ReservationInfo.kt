package hwang.macro.model

data class ReservationInfo(
    val ticketInfo: TicketInfo,    // 예약하려는 티켓 정보
    val paymentMethod: String      // 결제 방법 (예: "카드", "계좌이체")
)
