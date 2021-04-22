(ns galacart-gallery.db)

(def default-db
  {
    :paintings '(
                { :image "img/paintings/1_Acrilico_sobre_lienzo65x81cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>65x81cm" }
                { :image "img/paintings/2_Acrilico_tabla_122x98cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre tabla<br/>122x98cm" }
                { :image "img/paintings/3_Acrilico_sobre_lienzo_138x112cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>138x112cm" }
                { :image "img/paintings/4_Acrilico_sobre_arpillera_100x81cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre arpillera<br/>100x81cm" }
                { :image "img/paintings/5_Acrilico_Lienzo_123x100cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>123x100cm" }
                { :image "img/paintings/6_Acrilico_Tabla_2piezas_122x46cm_por_pieza.jpg"
                  :description "<b></b><br/><br/>Acrílico sobre tabla 2 piezas<br/>122x46cm cada una" }
                { :image "img/paintings/7_Acrilico_Tabla_30x30cm.jpg"
                  :description "<b></b><br/><br/>Acrílico sobre tabla<br/>30x30cm" }
                { :image "img/paintings/8_Acrilico_Tabla_30x30cm.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre tabla<br/>30x30cm" }
                { :image "img/paintings/9_Acrilico_3piezas.jpg"
                  :description "<b></b><br/><br/>Acrilico 3 piezas<br/>" }
                { :image "img/paintings/10_Acrilico_lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>185x175cm" }
                { :image "img/paintings/11_Acrilico_lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>180x176cm" }
                )
    :sculptures '(
                { :image "img/sculptures/1E_Bailaora_II_Bronce.jpg"
                  :description "<b>Bailaora II</b><br/><br/>Bronce<br/>34x21x20cm" }
                { :image "img/sculptures/2E_Arrastre_Bronce_madera.jpg"
                  :description "<b>Arrastre</b><br/><br/>Bronce y Madera<br/>40.5x23.5x20cm" }
                { :image "img/sculptures/3E_Hola_Bronce_Acero_Corten.jpg"
                  :description "<b>!Hola!</b><br/><br/>Bronce y Acero corten<br/>36x25x10cm"}
                { :image "img/sculptures/4E_Bailarina_Bronce_Patinado.jpg"
                  :description "Bailarina</b><br/><br/>Bronce patinado<br/>27x27x28cm" }
                { :image "img/sculptures/5E_Nina_nadadora_Bronce_pintado_Acero_corten.jpg"
                  :description "<b>Niña nadadora</b><br/><br/>Bronce pintado y Acero corten<br/>65x33x24cm" }
                { :image "img/sculptures/6E_Sensibilidad_III_Bronce_Madera.jpg"
                  :description "<b>Sensibilidad III</b><br/><br/>Bronce y Madera<br/>41x18x25cm" }
                { :image "img/sculptures/7E_Las_tres_M_Terracota.jpg"
                  :description "<b>Las tres M</b><br/><br/>Terracota" }
                { :image "img/sculptures/8E_Terracota.jpg"
                  :description "<b></b><br/><br/>Terracota<br/>15x45cm" }
                { :image "img/sculptures/9E_Terracota.jpg"
                  :description "<b></b><br/><br/>Terracota<br/>32x26cm" }
                { :image "img/sculptures/10E_Terracot_pigmentos.jpg"
                  :description "<b></b><br/><br/>Terracota con pigmentos<br/>23x35cm" }
                )
    :active-home-image-index 0
   })
