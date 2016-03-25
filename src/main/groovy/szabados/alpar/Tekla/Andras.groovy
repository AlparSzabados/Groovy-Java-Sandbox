package szabados.alpar.Tekla

import groovy.io.FileType

import java.awt.Desktop

class Andras {
    public static void main(String[] args) {

        // Elso feladat
        println "Találkozz 30 baráttal és tölts fel közös képeket"

        def counter = 0
        File file = new File("C:\\NewFolder")
        file.eachFileRecurse(FileType.FILES) {
            if (it.name.endsWith('.jpg'))
                counter += 1
        }
        println "Jelenleg  ${counter}  kép található az albumodban"

        if (counter == 14) {
            println "Sikeresen telyesítetted a feladatot"
            Desktop d = Desktop.getDesktop()
            d.browse(new URI("http://giphy.com/gifs/applause-clapping-clap-aLdiZJmmx4OVW"))
        } else {
            println "Talalkozz tobb barattal!"
        }

        // Masodik feladat
        def date2 = new Date().parse('yyyy/MM/dd','2016/03/29')
        if (date2.compareTo(new Date()) <= 0){
            println "Placeholder 2"
        }

//        // Harmadik feladat
//        def date3 = '2016/04/01'
//        if (time >= date3) {
//            println "Placeholder 3"
//        }
//        // Negyedik feladat
//        def date4 = '2016/04/06'
//        if (time >= date4) {
//            println "Placeholder 4"
//        }
//
//        // Otodik feladat
//        def date5 = '2016/04/11'
//        if (time >= date5) {
//            println "Placeholder 5"
//        }
//
//        // Hatodik feladat
//        def date6 = '2016/04/16'
//        if (time >= date6) {
//            println "Placeholder 6"
//        }
//
//        // Hetedik feladat
//        def date7 = '2016/04/22'
//        if (time >= date7) {
//            println "Placeholder 7"
//        }
//
//        // Nyolcadik feladat
//        def date8= '2016/04/26'
//        if (time >= date8) {
//            println "Placeholder 8"
//        }
//
//        // Kilencedik feladat
//        def date9 = '2016/05/02'
//        if (time >= date9) {
//            println "Placeholder 9"
//        }
//
//        // Tizedik feladat
//        def date10 = '2016/05/06'
//        if (time >= date10) {
//            println "Placeholder 10"
//        }
//
//        // Tizenegyedik feladat
//        def date11 = '2016/05/11'
//        if (time >= date11) {
//            println "Placeholder 11"
//        }
    }
}
