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
    [:div
     [:img {:class "home-image" :src @home-image}]
     ]))

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
  [:div {:class "about-container"}
   [:div {:style {:float "left"}}
     [:img {:src "img/ConchaGalan.jpg"}]]
   [:div {:style {:float "center"}}
     [:h1 "Welcome to my online gallery!"]
     [:p "Hi! I'm a part-time artist and this site contains all my works available for sale from my studio in Santa Ponsa, Mallorca."]
     [:p "If you are interested in any of the works or just have a question please don't hesitate to get in touch. I hope you enjoy the tour!"]
     [:h2 "Contact: info@galacart-gallery.eu"]
    ]
   ])


;; Main

(defn- panels [panel-name]
  [:div
   [:div {:class "header-banner"}
    [:h1 {:class "header-banner-text"} [:a {:href "#/" :class "header-banner-text"} "Galacart Gallery"]]
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
