import { useQuery } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { DiscData } from '../interface/DiscData';

const API_URL = 'http://localhost:8080/api';

const fetchData = async (): AxiosPromise<DiscData[]> => {
    const response = axios.get(API_URL + '/disc');
    return response;
}

export function useDiscData(){
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['disc-data'],
        retry: 2
    })

    return {
        ...query,
        data: query.data?.data
    }
}

