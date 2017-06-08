/**
 * Created by hendisantika on 6/6/17.
 */
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs';

@Injectable()
export class BeerService {
  public API = 'https://ionic-server-nonentertaining-fireproofing.cfapps.io';
  public BEER_API = this.API + '/beers';

  constructor(public http: Http) {}

  getGoodBeers(): Observable<any> {
    return this.http.get(this.API + '/good-beers')
      .map((response: Response) => response.json());
  }

  get(id: string) {
    return this.http.get(this.BEER_API + '/' + id)
      .map((response: Response) => response.json());
  }

  save(beer: any): Observable<any> {
    let result: Observable<Response>;
    if (beer['href']) {
      result = this.http.put(beer.href, beer);
    } else {
      result = this.http.post(this.BEER_API, beer)
    }
    return result.map((response: Response) => response.json())
      .catch(error => Observable.throw(error));
  }

  remove(id: string) {
    return this.http.delete(this.BEER_API + '/' + id)
      .map((response: Response) => response.json());
  }
}
