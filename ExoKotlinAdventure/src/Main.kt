import kotlin.math.max
import kotlin.random.Random

fun calculDefenseTotal(defense:Int, typeArmure:Int, raretéArmure:Int):Int{
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

fun boirePotion(NameTarget: String,pv: Int,pvMax:Int,PuissanceP:Int) {
    val exPV =pv
    var nv_pv = exPV + PuissanceP
    if (pv + PuissanceP > pvMax){
        nv_pv = pvMax
    }
    val pointRecuperes = nv_pv - exPV
    println("$NameTarget boit une potion et récupère $pointRecuperes pv")
}

fun bouleDeFeu(nameCaster:String,NameTarget: String,scoreAtt:Int,scoreDef:Int,nbPv:Int) {
    var pv = nbPv
    var degatInflige = lanceDes(scoreAtt / 3, 6)
    if (degatInflige < 0) degatInflige = 0
    degatInflige - scoreDef
    if (degatInflige > pv) pv = 0
    else pv -= degatInflige

    println("$$nameCaster lance une boule de feu et inflige $degatInflige dégat à $NameTarget")
}
fun lancerMissileMagique(nameCaster: String, nameTarget: String, scoreAtt: Int, scoreDef: Int, pvCible: Int) {
    var pvRestants = pvCible
    var nbMissiles = scoreAtt / 2

    for (i in 1..nbMissiles) {
        if (pvRestants <= 0) {
            println("$nameTarget est déjà à 0 PVs")
            break
        }
        var MissileDeg = lanceDes(1, 6) + scoreDef
        val degatsInfliges = if (MissileDeg > 0) MissileDeg else 0
        pvRestants -= degatsInfliges
        if (pvRestants < 0) pvRestants = 0
        println("$nameCaster lance un missile magique et inflige $degatsInfliges points de dégâts à $nameTarget.")
        if (pvRestants == 0) {
            println("$nameTarget a atteint 0 PV et est vaincu.")
            break
        }
    }
    println("Il reste $pvRestants PV à $nameTarget.")
}

fun main() {
    //exo1
    //println(calculDefenseTotal(3,2,6))
    //println(lanceDes(3,15)) // exo2
    //println(calculDegatArme(1,6,2,6,2)) //exo3
    //println(attaque(15,3,4,"Goku","Végéta")) //exo4
    //println(boirePotion("Végéta",8,20,6)) //exo5
   //println(bouleDeFeu("Végéta","Goku",78,54,98)) //exo6
    println(lancerMissileMagique("Végéta","Goku",65,14,98)) //exo7
}
