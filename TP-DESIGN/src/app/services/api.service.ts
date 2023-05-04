import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl1 = '/api/v2/User/';
  private baseUrl2 = '/api/v1/User/';


  constructor(private http : HttpClient) { }

  getUser() : Observable<Object> {
    return this.http.get(this.baseUrl2, {headers:this.httpHeaders()});
  }

  createUser(personne : any): Observable<Object> {
    return this.http.post(this.baseUrl1+"Register", personne, {headers: this.httpHeaders()});
  }

  userLogin(EmailAndPassword:any):Observable<Object>{
    return this.http.post(this.baseUrl1+"Login",EmailAndPassword, {headers: this.httpHeaders()})
  }

  updateUser(id: number, personne: any): Observable<Object> {
    return this.http.put(this.baseUrl2 + 'update/' + id, personne, {headers: this.httpHeaders()});
  }

  deleteUser(id:number) : Observable<Object>{
    return this.http.delete(this.baseUrl2 + 'delete/' + id, {headers:this.httpHeaders()});
  }

  httpHeaders(){
    return new HttpHeaders({
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods':'POST,GET,OPTIONS,PUT',
      
    })
    
  }
}
