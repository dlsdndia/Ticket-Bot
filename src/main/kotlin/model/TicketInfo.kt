package hwang.macro.model

data class TicketInfo(
    val eventName: String,         // 공연 또는 이벤트 이름
    val eventDate: String,         // 공연 날짜 (예: "2023-09-30")
    val eventTime: String,         // 공연 시간 (예: "19:00")
    val seatInfo: SeatInfo,        // 선택한 좌석 정보
    val price: Int                 // 티켓 가격
)
