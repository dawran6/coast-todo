(ns middleware
  (:require [coast]))

(defn auth [handler]
  (fn [request]
    (if (get-in request [:session :auth])
      (handler request)
      (coast/unauthorized "HAL9000 says: I'm sorry Dave, I can't let you do that"))))
