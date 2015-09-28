(defproject hello_seymore "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [sablono "0.3.5"]
                 [domina "1.0.0"]
                 [org.omcljs/om "0.8.8"]
                 [racehub/om-bootstrap "0.5.3"]]
  :plugins [[lein-figwheel "0.3.8"]
            [lein-cljsbuild "0.2.3"]]

  :clean-targets [:target-path "out"]
  :cljsbuild {
              :builds [{:id           "dev"
                        :source-paths ["src"]
                        :figwheel     {:on-jsload "hello_seymore.core/render!"}
                        :compiler     {:main hello_seymore.core
                                       :output-to "main.js"
                                       :output-dir "out"
                                       :optimizations :none
                                       :source-map true}
                        }]
              }
  :figwheel { ;; <- add server config
             :css-dirs ["css"]
   })