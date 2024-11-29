import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  public BASE_URL: string = 'http://localhost:8080/car-rental-service/api/';
  public SERVER_URL: any = {
    "ROLE_LIST": 'user-type/list',
    "LOGIN": 'user/login'
  }
  constructor(private httpClient: HttpClient) { }

  getRequest<T>(url: string): Observable<T> {
    return this.httpClient.get<T>(this.BASE_URL + url);
  }

  getRequestWithHeaders<T>(url: string, headers?: HttpHeaders): Observable<T> {
    return this.httpClient.get<T>(this.BASE_URL + url, { headers });
  }


  // POST request without headers
  postRequestWithHeaders<T>(url: string, payload: T): Observable<any> {
    return this.httpClient.post<any>(this.BASE_URL + url, payload); // No headers, using default
  }

  // POST request with optional headers
  postRequest<T>(url: string, payload: T): Observable<any> {
    const timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Timezone': timezone // Add your timezone header here
    });
    return this.httpClient.post<any>(this.BASE_URL + url, payload, { headers });
  }

  // PUT request with optional headers
  putRequest<T>(url: string, payload: T): Observable<any> {
    return this.httpClient.put<any>(this.BASE_URL + url, payload);
  }

  putRequestWithHeaders<T>(url: string, payload: T, headers?: HttpHeaders): Observable<any> {
    return this.httpClient.put<any>(this.BASE_URL + url, payload, { headers });
  }

  // DELETE request with optional headers

  deleteRequestWithHeaders(url: string, headers?: HttpHeaders): Observable<any> {
    return this.httpClient.delete<any>(this.BASE_URL + url, { headers });
  }

  deleteRequest(url: string): Observable<any> {
    return this.httpClient.delete<any>(this.BASE_URL + url);
  }
}
