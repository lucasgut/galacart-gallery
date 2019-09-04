(ns galacart-gallery.subs
  (:require
    [re-frame.core :as re-frame])
  )

(re-frame/reg-sub
  ::home-image
  (fn [db]
    (:image (nth (:paintings db) (:active-home-image-index db)))))

(re-frame/reg-sub
  ::paintings
  (fn [db]
    (:paintings db)))

(re-frame/reg-sub
  ::sculptures
  (fn [db]
    (:sculptures db)))

(re-frame/reg-sub
  ::active-panel
  (fn [db _]
    (:active-panel db)))

(re-frame/reg-sub
  ::product-image-modal
  (fn [db _]
    (:product-image-modal db)))
