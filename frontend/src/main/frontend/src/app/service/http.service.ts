import {Injectable} from "@angular/core";
import {Http, Headers, URLSearchParams} from "@angular/http";


@Injectable()
export class HttpService {

  private host: string = 'http://localhost:8066/war-1.0-SNAPSHOT/';

  constructor(private http: Http) {}

  post(url: string, params: URLSearchParams) {
    const headers = this.getHeaders();
    return this.http.post(this.host + url, null, {
      headers: headers,
      params: params
    });
  }

  getHeaders(): Headers {
    const csrfToken = this.getCsrfToken();
    return new Headers({
      'Accept': 'application/json',
      'X-CSRF-TOKEN': csrfToken
    });
}

  getCsrfToken(): string {
    return this.getCookie('JSESSIONID');
  }

  // Given a cookie key `name`, returns the value of
  // the cookie or `null`, if the key is not found.
  getCookie(name: string): string {
    const nameLenPlus = (name.length + 1);
    return document.cookie
        .split(';')
        .map(c => c.trim())
        .filter(cookie => {
          return cookie.substring(0, nameLenPlus) === `${name}=`;
        })
        .map(cookie => {
          return decodeURIComponent(cookie.substring(nameLenPlus));
        })[0] || null;
  }

  deleteAllCookies() {
    document.cookie
      .split(';')
      .forEach(cookie => {
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
      });
  }

}
