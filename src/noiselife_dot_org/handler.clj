(ns noiselife-dot-org.handler
  (:require [liberator.core :refer [resource defresource]]
            [liberator.representation :refer [ring-response]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET OPTIONS]]
            [cljstache.core :refer [render]]
            [clj-time.core :as t]))

(def root-template "
<!DOCTYPE html>
  <html lang=\"en\">
  <head>
    <title>noiselife-dot-org</title>
    <meta charset=\"UTF-8\">
  </head>
  </body>
  <p>\"hell world\"</p>
  </body>
  </html>")



(defroutes app-routes
  (GET "/" [] (render root-template)))
  

(def app
  (wrap-params app-routes))
