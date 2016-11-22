package PartTwo.P1;

import rx.Observable;

public class Main {
    public static void main(String[] args) {
        UrlWorker.query("redmadrobot")
                .subscribe(urls -> {
                    for (String url : urls) {
                        System.out.println(url);
                        UrlWorker.connect(url);
                    }
                });

        UrlWorker.query("yandex")
                .subscribe(urls -> Observable.from(urls)
                        .subscribe(url -> System.out.println("usually: " + url)));

        UrlWorker.query("ohmygoddatrx")
                .flatMap(urls -> Observable.from(urls))
                .subscribe(url -> System.out.println("banned: " + url));

        UrlWorker.query("WTFTHISISRX")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> UrlWorker.getTitle(url))
                .subscribe(title -> System.out.println("tittle: " + title));

        UrlWorker.query("null")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> UrlWorker.getTitle(url))
                .filter(nullable -> !nullable.equals("null"))
                .subscribe(title -> System.out.println("tittle not null: " + title));

        UrlWorker.query("LARGElengthStringQuery")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> UrlWorker.getTitle(url))
                .filter(title -> (title.length() > 10))
                .subscribe(title -> System.out.println("tittle >10: " + title));

        UrlWorker.query("how_many")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> UrlWorker.getTitle(url))
                .takeLast(2)
                .subscribe(title -> System.out.println(("tittle (only last 2): " + title)));

        UrlWorker.query("more_cites")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> UrlWorker.getTitle(url))
                .doOnNext(title -> UrlWorker.saveTitle(title))
                .doOnNext(i -> System.out.println(UrlWorker.getCount()))
                .subscribe(title -> System.out.println("saved title: " + title));

    }

}
