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
  [:div {:class "home-container"}
   [:p "Welcome!"]
   ])

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

;; Contact

(defn contact-panel []
  [:div {:class "contact-container"}
   [:img {:src "img/smiley.jpg"}]
   [:p "Concha aka Galacart, la autora de Pinturas Mallorca"]
   ])


;; Main

(defn- panels [panel-name]
  [:div
   [:h1 {:class "header-banner"} "Mallorca Paintings & Sculptures - Galacart Gallery"]
   [:div {:class "menu-and-products-container"}
    [:ul
     [:li [:a {:href "#/"} "Home"]]
     [:li [:a {:href "#/paintings"} "Paintings"]]
     [:li [:a {:href "#/sculptures"} "Sculptures"]]
     [:li [:a {:href "#/contact"} "Contact"]]
     ]
    (case panel-name
      :home-panel [home-panel]
      :paintings-panel [paintings-panel]
      :sculptures-panel [sculptures-panel]
      :contact-panel [contact-panel]
      [:div])
    ]
   ])


(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
