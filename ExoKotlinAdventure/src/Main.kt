fun calculDefenseTotal(defense:Int,typeArmure:Int,raretéArmure:Int):Int{
    return defense + typeArmure + raretéArmure
}
fun lanceDes(nombreDes:Int,nombresFaces:Int):Int{
    return (nombreDes..nombresFaces*nombreDes).random()
}
fun calculDegatArme(nbDes:Int,nbFaces:Int,Bonus:Int,ActivationCc:Int,MultiplicateurCc:Int):Int{
    val degat = lanceDes(nbDes,nbFaces)

    if (degat >= ActivationCc) degat * MultiplicateurCc
    degat + Bonus

    if( degat < 0)
        return 0
    else
        return degat
}
fun attaque(Pv:Int,defTotale:Int,degArme:Int,NameAttak:String,NameTarget:String) {
    val deg = degArme - defTotale

    if (deg >= 0)
        Pv - degArme
    if (Pv < degArme) Pv - Pv
    else (Pv < 0)
    println("$NameAttak attaque $NameTarget pour $degArme")
}

fun boirePotion(NameTargetP: String,pv: Int,pvMax:Int,PuissanceP:Int) {
    val exPV =pv
    var nv_pv = exPV + PuissanceP
    if (pv + PuissanceP > pvMax){
        nv_pv = pvMax
    }
    val pointRecuperes = nv_pv - exPV
    println("$NameTargetP boit une potion est récupere $pointRecuperes pv")
}

fun main() {
    //exo1
    //println(calculDefenseTotal(3,2,6))
    //println(lanceDes(3,15))
    //println(calculDegatArme(1,6,2,6,2))
    //println(attaque(15,3,4,"Goku","Végéta"))
    println(boirePotion("Végéta",8,20,6))
}
