package `fun`.gladkikh.fastpallets.domain.model

data class Pallet(val guid:String,var number:String,var boxes: List<Box>)
data class Box(val guid:String,val pallet:String,var weght:Float)