import {Injectable} from "@angular/core";
import {HttpService} from "./http.service";
import {URLSearchParams} from "@angular/http";

@Injectable()
export class AuthService {

  constructor(private httpService: HttpService) {}

  checkCard(cardNumber: string): Promise<string> {
    let params = new URLSearchParams();
    params.append('cardNumber', cardNumber);
    return this.httpService.post('api/v1/authManagement/checkCard', params)
      .toPromise()
      .then(response => {
        return response.json().status as string
      })
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.error || error);
  }
}
