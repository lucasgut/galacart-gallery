(ns galacart-gallery.db)

(def default-db
  {
    :paintings '(
                { :image "img/P1_Acrilico_Tabla_2piezas.jpg"
                  :description "<b></b><br/><br/>Acrílico Tabla 2 piezas<br/>122x46cm cada una" }
                { :image "img/P2_Acrilico_sobre_lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>138x112cm" }
                { :image "img/P3_Acrilico_lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>185x175cm" }
                { :image "img/P4_Acrilico_tabla.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre tabla<br/>122x98cm" }
                { :image "img/P5_Acrilico_Tabla.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre tabla<br/>48x122cm" }
                { :image "img/P6_Tecnica_mixta_lienzo.jpg"
                  :description "<b></b><br/><br/>Tecnica mixta sobre lienzo<br/>80x65cm" }
                { :image "img/P7_Acrilico_tabla.jpg"
                  :description "<b></b><br/><br/>Tecnica mixta sobre lienzo<br/>120x80cm" }
                { :image "img/P8_Acrilico_lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>180x176cm" }
                { :image "img/P9_Acrilico_Lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>123x100cm" }
                { :image "img/P10_Acrilico_Lienzo.jpg"
                  :description "<b></b><br/><br/>Acrilico sobre lienzo<br/>93x74cm" }
                )
    :sculptures '(
                { :image "img/1E_Bailaora_II_Bronce.jpg"
                  :description "<b>Bailaora II</b><br/><br/>Bronce<br/>34x21x20cm" }
                { :image "img/2E_Arrastre_Bronce_madera.jpg"
                  :description "<b>Arrastre</b><br/><br/>Bronce y Madera<br/>40.5x23.5x20cm" }
                { :image "img/3E_Hola_Bronce_Acero_Corten.jpg"
                  :description "<b>!Hola!</b><br/><br/>Bronce y Acero corten<br/>36x25x10cm"}
                { :image "img/4E_Bailarina_Bronce_Patinado.jpg"
                  :description "Bailarina</b><br/><br/>Bronce patinado<br/>27x27x28cm" }
                { :image "img/5E_Nina_nadadora_Bronce_pintado_Acero_corten.jpg"
                  :description "<b>Niña nadadora</b><br/><br/>Bronce pintado y Acero corten<br/>65x33x24cm" }
                { :image "img/6E_Sensibilidad_III_Bronce_Madera.jpg"
                  :description "<b>Sensibilidad III</b><br/><br/>Bronce y Madera<br/>41x18x25cm" }
                { :image "img/7E_Las_tres_M_Terracota.jpg"
                  :description "<b>Las tres M</b><br/><br/>Terracota" }
                { :image "img/8E_Terracota.jpg"
                  :description "<b></b><br/><br/>Terracota<br/>15x45cm" }
                { :image "img/9E_Terracota.jpg"
                  :description "<b></b><br/><br/>Terracota<br/>32x26cm" }
                { :image "img/10E_Terracot_pigmentos.jpg"
                  :description "<b></b><br/><br/>Terracota con pigmentos<br/>23x35cm" }
                )
    :active-home-image-index 0
   })
