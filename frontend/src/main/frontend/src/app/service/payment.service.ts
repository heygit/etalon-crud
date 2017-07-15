import {Injectable} from "@angular/core";
import {HttpService} from "./http.service";
import {URLSearchParams} from "@angular/http";

import 'rxjs/add/operator/toPromise';
import {BalanceModel} from "../model/balance-model";

@Injectable()
export class PaymentService {

  constructor(private httpService: HttpService) {}

  getBalance(): Promise<BalanceModel> {
    let params = new URLSearchParams();
    return this.httpService.post('api/v1/paymentManagement/getBalance', params)
      .toPromise()
      .then(response => {
        return response.json().balance as BalanceModel;
      })
      .catch(this.handleError);
  }

  getCash(pin: string): Promise<string> {
    let params = new URLSearchParams();
    params.append('pin', pin);
    return this.httpService.post('api/v1/paymentManagement/getCash', params)
      .toPromise()
      .then(response => {
        return response.json().status as string
      })
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.error || error);
  }
}
