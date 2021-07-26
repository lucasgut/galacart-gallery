(ns galacart-gallery.views
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.subs :as subs]
    [galacart-gallery.events :as events]
    ))


;; Product image modal, hidden by default

(defn product-image-modal []
  (let [product-image-modal (re-frame/subscribe [::subs/product-image-modal])]
    [:div {:class "product-image-modal"
           :style {:display (if (:visible @product-image-modal) "block" "none")}}
     [:div
      [:span {:dangerouslySetInnerHTML {:__html "&times;"}
              :on-click #(re-frame/dispatch [::events/toggle-product-image-modal {:visible false}])}]     ;; cross symbol to close window
      [:img {:src (:image-path @product-image-modal)}]
      ]]))


;; Home

(defn home-panel []
  (let [home-image (re-frame/subscribe [::subs/home-image])]
    [:div {:class "home-container"}
      [:div {:style {:float "left"}}
        [:img {:class "home-image" :src @home-image}]
        ]  
      [:div {:style {:float "right" :max-width "40vw"}}
        [:h1 "Welcome! Bienvenidos!"]
        [:p {:class "home-text"} 
           "Hi I'm Maria, thanks for visiting my website where you can find some of my works - paintings and sculptures."[:br][:br]
           "My studio is located in Santa Ponsa, Mallorca (Spain), and I can be reached via e-mail."]
        [:hr]
        [:p {:class "home-text"} 
           "Hola soy María, gracias por visitar esta página donde puedes ver alguna de mis obras, pinturas y esculturas."[:br][:br]
           "Mi taller lo tengo en Santa Ponsa, Mallorca, y si quieres contactar lo puedes hacer en mi enlace."]
        ]  
    ]
  ))

;; Paintings

(defn paintings-panel []
  (let [paintings (re-frame/subscribe [::subs/paintings])]
    [:div {:class "painting-list-container"}
     [product-image-modal]   ;; Render product image modal, hidden by default
     (for [painting (seq @paintings)]
       ^{:key painting}       ;; metadata to avoid warning with iterator requiring a key
       [:div {:class "painting-container"}
        [:img {:src (:image painting)
               :on-click #(re-frame/dispatch [::events/toggle-product-image-modal {:visible true
                                                                                   :image-path (:image painting)}])
               }]
        [:p {:dangerouslySetInnerHTML {:__html (:description painting)}}]]
       )]
    ))

;; Sculptures

(defn sculptures-panel []
  (let [sculptures (re-frame/subscribe [::subs/sculptures])]
    [:div {:class "sculpture-list-container"}
     [product-image-modal]   ;; Render product image modal, hidden by default
     (for [sculpture (seq @sculptures)]
       ^{:key sculpture}       ;; metadata to avoid warning with iterator requiring a key
       [:div {:class "sculpture-container"}
        [:img {:src (:image sculpture)
               :on-click #(re-frame/dispatch [::events/toggle-product-image-modal {:visible true
                                                                                   :image-path (:image sculpture)}])
               }]
        [:p {:dangerouslySetInnerHTML {:__html (:description sculpture)}}]]
       )]
    ))

;; About

(defn about-panel []
  [:div {:class "about-container; about-text"}
   [:div {:style {:float "center"}}
     [:p
        "El arte siempre ha estado presente en mi vida, ha sido mi guía durante los muchos años vividos en diferentes países en los que no he dejado nunca de observar y aprender."[:br]
        "Mi residencia ahora es la isla de Mallorca donde continúo haciendo lo que me gusta, crear, expresar a través de la escultura o la pintura."[:br]
        "El arte sirve de tránsito entre el sentimiento que nace del artista y el que recibe el espectador; y eso es lo que intento transmitir desde mi taller de Santa Ponsa."]
     [:img {:class "about-image" :src "img/about.jpg"}]
     [:p
        "Arts are my lifelong passion that have guided me to observe and learn whilst living in different countries around the world."[:br]
        "I live on the island of Mallorca now where I continue to create and express art through sculptures and paintings."[:br]
        "Art acts as a medium to convey the artists emotions to those who receive it which is what I aim to do from my workshop in Santa Ponsa."]
    ]
   ])


;; Main

(defn- panels [panel-name]
  [:div
   [:div {:class "header-banner"}
    [:h1 {:class "header-banner-text"} [:a {:href "#/home" :class "header-banner-text"} "Galacart Gallery"]]
    [:p {:class "header-banner-subtext"} "Mallorca, Santa Ponsa"]]
   [:div {:class "menu-and-products-container"}
    [:ul
     [:li [:a {:href "#/paintings"} "Paintings"]]
     [:li [:a {:href "#/sculptures"} "Sculptures"]]
     [:li [:a {:href "#/about"} "About"]]
     ]
    (case panel-name
      :home-panel [home-panel]
      :paintings-panel [paintings-panel]
      :sculptures-panel [sculptures-panel]
      :about-panel [about-panel]
      [:div])
    ]
   ])


(defn show-panel [panel-name]
  [panels panel-name])

;; Timer function called every 5 seconds to change the home page image
(defn dispatch-timer-event []
    (re-frame/dispatch [::events/change-home-image]))

(defn main-panel []
  (defonce do-timer (js/setInterval dispatch-timer-event 5000))
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
