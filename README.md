# galacart-gallery

*Galacart Gallery* website implemented in Clojurescript with [re-frame](https://github.com/Day8/re-frame).

## Development Mode

```
lein clean
lein figwheel dev
```

Browse [http://localhost:3449](http://localhost:3449)

## Production Build

To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
