package hwang.macro.model

data class SeatInfo(
    val section: String,           // 좌석 구역 (예: "R석", "S석")
    val row: String,               // 좌석 줄 번호 (예: "A", "B")
    val seatNumber: Int            // 좌석 번호
)
