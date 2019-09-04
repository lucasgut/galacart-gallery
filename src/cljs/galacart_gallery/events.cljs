(ns galacart-gallery.events
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.db :as db]
    ))

(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-db
  ::set-active-panel
  (fn [db [_ active-panel]]
    (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
  ::toggle-product-image-modal
  (fn [db [_ product-image-modal]]
    (assoc db :product-image-modal product-image-modal)))

(re-frame/reg-event-db
  ::change-home-image
  (fn [db [_]]
    (assoc db :active-home-image-index (rand-int (count (:paintings db))))))
